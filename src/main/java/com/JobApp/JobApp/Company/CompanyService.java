package com.JobApp.JobApp.Company;

import java.util.List;
import java.util.Optional;


public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompany(Long id ,Company company);
    void createCompany(Company company);
    boolean  deleteCompanyById(Long id);
    Company getCompanyById(Long id);
}
