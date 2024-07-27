package com.JobApp.JobApp.Company;

import com.JobApp.JobApp.Job.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
  private CompanyService companyService ;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies(){
        return new ResponseEntity<>(companyService.getAllCompanies() ,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id ,
                                                @RequestBody Company company){
         boolean isUpdated=companyService.updateCompany(id , company);
         return  isUpdated? new ResponseEntity<>("Company Updated Successfully " , HttpStatus.OK):
                 new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public  ResponseEntity<String> addCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new  ResponseEntity<>("Company added Successfully" ,HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteCompany(@PathVariable Long id){
       return companyService.deleteCompanyById(id)? new ResponseEntity<>("Company Deleted Successfully" ,HttpStatus.OK):
               new ResponseEntity<>("Company not found ",HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyByID(@PathVariable Long id ){

        Company company = companyService.getCompanyById(id);

        return company!=null ? new ResponseEntity<>(company ,HttpStatus.FOUND):new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
