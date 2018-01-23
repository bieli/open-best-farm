package net.bieli.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Api(value = "object", description = "Rest API for object operations", tags = "Object API")
public class ApiObjectController {

        @RequestMapping(value = "/object", method = RequestMethod.GET, produces = "application/json")
        @ResponseStatus(HttpStatus.OK)
        @ResponseBody
        @ApiOperation(value = "Get all objects", response = String.class)
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "OK"),
        }
        )
        public String getAllObjects() {
            return "[{\"id\": \"dfdc04cd-dd48-4587-9466-78c82709392c\", \"name\":\"little barn\"}, " +
                    "{\"id\": \"a37d0ee5-4088-44bf-a254-db8556ca077d\", \"name\":\"first mill machine\"}]";
        }
}
