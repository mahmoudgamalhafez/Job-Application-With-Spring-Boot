package com.JobApp.JobApp.Company.Impl;

import com.JobApp.JobApp.Company.Company;
import com.JobApp.JobApp.Company.CompanyRepository;
import com.JobApp.JobApp.Company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository ;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Long id,Company updatedCompay) {
        Optional<Company> companyOptional =companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company company = companyOptional.get();
            company.setDescreption(updatedCompay.getDescreption());
            company.setJobs(updatedCompay.getJobs());
            company.setName(updatedCompay.getName());
            companyRepository.save(company);
            return true ;
        }

        return false;    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }
    public boolean  deleteCompanyById(Long id) {
        if(companyRepository.existsById(id))
        {
            companyRepository.deleteById(id);
            return  true ;
        }
        return  false ;

    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }
}
