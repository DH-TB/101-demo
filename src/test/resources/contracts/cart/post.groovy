package cart

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/carts'
        body("""
                  {
                          "id":3, 
                          "name": "cart3"
                  }
                """)
        headers {
            header('Content-Type', 'application/json;charset=UTF-8')
        }
    }
    response {
        status 201
    }
}
