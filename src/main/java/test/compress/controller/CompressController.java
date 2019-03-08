package test.compress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import test.compress.service.CompressService;

@RestController
public class CompressController {


    @Autowired
    private CompressService compressService;


    @RequestMapping(value = "/compress/", method = RequestMethod.POST)
    public ResponseEntity<CompressResponse> compress(@RequestBody CadenaDTO cadena) {
        CompressResponse compressResponse = new CompressResponse();
        compressResponse.setCompressed(compressService.compress(cadena.getValue()));
        return new ResponseEntity<CompressResponse>(compressResponse, HttpStatus.OK);

        //return new ResponseEntity<>( HttpStatus.FORBIDDEN);
    }

    @RequestMapping(value = "/candidate/", method = RequestMethod.GET)
    public ResponseEntity<String> candidate() {
            return new ResponseEntity<String>(
                    compressService.getCandito(), HttpStatus.OK);

    }
}
