package category

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'PUT'
        url value(consumer(regex('/categorys/\\d+')),producer('/categorys/1'))
        body("""
                  {
                          "name": "修改饮料"
                  }
                """)
        headers {
            header('Content-Type', 'application/json;charset=UTF-8')
        }
    }
    response {
        status 204
    }
}
