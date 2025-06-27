package com.lagom.meulugar.service.table;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagom.meulugar.infrastructure.enums.TableStatusEnum;
import com.lagom.meulugar.model.table.Tables;
import com.lagom.meulugar.repository.table.TableRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    public Tables createTable(Tables tableCreateForm){
        Tables newTable = getById(tableCreateForm.getId());
        if(newTable != null){
            throw new EntityExistsException(String.format("Essa mesa já está cadastrada %s - %s ", tableCreateForm.getId(), tableCreateForm.getTableIdentifier()));
        }
        if(getByIdentifier(tableCreateForm.getTableIdentifier()) != null){
            throw new EntityExistsException(String.format("Essa mesa já está cadastrada %s", tableCreateForm.getTableIdentifier()));
        }
        newTable.setId(null);
        newTable.setTableIdentifier(tableCreateForm.getTableIdentifier());
        newTable.setCapacity(tableCreateForm.getCapacity());
        newTable.setStatus(tableCreateForm.getStatus() != null ? tableCreateForm.getStatus() : TableStatusEnum.AVAIABLE);
        newTable.setReserves(null);
        newTable = tableRepository.save(newTable);
        return newTable;
    }

    public Tables updateTable(Long id, Map<String, Object> updateForm){
        Tables currentTable = getById(id);
        ObjectMapper objectMapper = new ObjectMapper();
        Tables tableMapped = objectMapper.convertValue(updateForm, Tables.class);

        for(Map.Entry<String, Object> entry: updateForm.entrySet()){
            Field attribute = ReflectionUtils.findField(Tables.class, entry.getKey());
            if (attribute != null) {
                attribute.setAccessible(true);
                Object attributeValue = ReflectionUtils.getField(attribute, tableMapped);

                if(attribute.getName().equalsIgnoreCase("tableIdentifier") && attributeValue instanceof String identifier){
                    return tableRepository.findByTableIdentifier(identifier)
                            .orElseThrow(()-> new EntityExistsException(String.format("Mesa já existe %s", attributeValue)));
                }
                ReflectionUtils.setField(attribute, currentTable, attributeValue);
            }
        }
        return tableRepository.save(currentTable);
    }

    public List<Tables> getAll(){
        List<Tables> allTables = tableRepository.findAll();
        if(allTables.isEmpty()){
            throw new EntityNotFoundException("Não há mesas cadastradas.");
        }
        return allTables;
    }

    public Tables getById(Long id){
        return tableRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Mesa não encontrada."));
    }

    public Tables getByIdentifier(String identifier){
        return tableRepository.findByTableIdentifier(identifier)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Essa mesa já está cadastrada %s", identifier)));
    }

    public void deletetable(Long id){
        Tables table = getById(id);
        tableRepository.deleteById(table.getId());
    }


}
