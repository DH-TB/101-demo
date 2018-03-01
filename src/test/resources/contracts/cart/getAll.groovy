package cart

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/carts'
    }
    response {
        status 200
        body("""
                  [{
                          "id": 1,
                          "name": "cart1",
                  }]
                """)
        testMatchers {
            jsonPath('$.[*].id', byRegex(number()))
        }
    }
}
