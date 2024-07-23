package com.cbt.cbtjul24template;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MainRestController
{
    @Autowired
    UserdetailRepository userdetailRepository;

    @PostMapping("update/user/details")
    public ResponseEntity<Userdetail> updateUserDetails(@RequestBody Userdetail userdetail)
    {
        userdetailRepository.updateFnameAndLnameAndEmailAndPhoneAndCityAndCountryByUsername(
                userdetail.getFname(),
                userdetail.getLname(),
                userdetail.getEmail(),
                userdetail.getPhone(),
                userdetail.getCity(),
                userdetail.getCountry(),
                userdetail.getUsername()
        );

        return ResponseEntity.ok().body(userdetail);
    }
}
