package com.lagom.meulugar.service.company;

import com.lagom.meulugar.model.company.Company;
import com.lagom.meulugar.repository.company.CompanyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> findAll(){
        List<Company>  companies = companyRepository.findAll();
        if(companies.isEmpty()){
            throw new EntityNotFoundException("Não há empresas cadastradas.");
        }
        return companies;
    }

    public Company findById(Long id){
        Optional<Company> company = companyRepository.findById(id);
        if(company.isEmpty()){
            throw new EntityNotFoundException("Empresa não encontrada.");
        }
        return company.get();
    }

}
