package contracts

import org.springframework.cloud.contract.spec.Contract
[
        Contract.make {
            description ("notification Contract")
            name ("cinemacatalog_getNotification")
            request {
                method ("GET")
                url("/getNotification") {
                    queryParameters {
                        parameter("userID", "1")
                    }
                }
            }
            response {
                status (200)
            }
        }
]