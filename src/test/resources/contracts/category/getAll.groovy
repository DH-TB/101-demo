package category

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/categorys'
    }
    response {
        status 200
        body("""
                  [{
                          "id": 1,
                          "name": "饮料"
                  }]
                """)
        testMatchers {
            jsonPath('$.[*].id', byRegex(number()))
        }
    }
}
