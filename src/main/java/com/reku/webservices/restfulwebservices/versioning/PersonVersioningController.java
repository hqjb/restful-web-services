package com.reku.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @GetMapping("v1/person")
    public PersonV1 personV1() {
        return new PersonV1("Bob");
    }

    @GetMapping(value = "/person/param", params = "version=1")
    public PersonV1 paramsV1() {
        return new PersonV1("Bob");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 paramsV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 headersV1() {
        return new PersonV1("Bob");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 headersV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonV1 producesV1() {
        return new PersonV1("Bob");
    }

    @GetMapping(value = "/person/produces", headers = "application/vnd.company.app-v2+json")
    public PersonV2 producesV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }


}
