package item

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/items'
        body("""
                  {
                          "id":3, 
                          "name": "饮料",
                          "price":3.00
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
