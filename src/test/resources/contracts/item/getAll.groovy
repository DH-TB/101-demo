package item

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/items'
    }
    response {
        status 200
        body("""
                  [{
                          "id": 1,
                          "name": "饮料",
                          "price":3.00
                  }]
                """)
        testMatchers {
            jsonPath('$.[*].id', byRegex(number()))
            jsonPath('$.[*].name', byRegex(onlyAlphaUnicode()))
            jsonPath('$.[*].price', byRegex(number()))
        }
    }
}
