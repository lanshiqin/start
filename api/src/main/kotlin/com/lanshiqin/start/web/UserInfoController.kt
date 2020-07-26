package com.lanshiqin.start.web

import com.fasterxml.jackson.databind.ObjectMapper
import com.lanshiqin.start.core.base.BaseResponse
import com.lanshiqin.start.core.base.ListResult
import com.lanshiqin.start.model.*
import com.lanshiqin.start.service.UserService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
@Api(value = "/api/user", tags = ["用户信息维护相关接口"], position = 1)
class UserInfoController {

    private companion object {
        val logger: Logger = LoggerFactory.getLogger(UserInfoController::class.java)
    }

    @Autowired
    private lateinit var userServiceImpl: UserService

    @PostMapping("/addUser")
    @ApiOperation(value = "新增用户", position = 1)
    fun addUser(@RequestBody request: AddUserRequest): BaseResponse<String> {
        logger.info("新增用户入参:{}", ObjectMapper().writerWithDefaultPrettyPrinter()
                .writeValueAsString(request))
        userServiceImpl.addUser(request.name)
        return BaseResponse.success("新增成功")
    }

    @PostMapping("/deleteUser")
    @ApiOperation(value = "删除用户", position = 2)
    fun deleteUser(@RequestBody request: DeleteUserRequest): BaseResponse<String> {
        logger.info("删除用户入参:{}", ObjectMapper().writerWithDefaultPrettyPrinter()
                .writeValueAsString(request))
        return BaseResponse.success("删除成功")
    }

    @PostMapping("/updateUser")
    @ApiOperation(value = "更新用户", position = 3)
    fun updateUser(@RequestBody request: UpdateUserRequest): BaseResponse<String> {
        logger.info("更新用户入参:{}", ObjectMapper().writerWithDefaultPrettyPrinter()
                .writeValueAsString(request))
        return BaseResponse.success("更新成功")
    }

    @PostMapping("/queryUserById")
    @ApiOperation(value = "查询用户", position = 4)
    fun queryUserById(@RequestBody request: QueryUserByIdRequest): BaseResponse<QueryUserByIdResponse> {
        logger.info("查询用户入参:{}", ObjectMapper().writerWithDefaultPrettyPrinter()
                .writeValueAsString(request))
        val response = QueryUserByIdResponse()
        return BaseResponse.success("查询用户", response)
    }

    @PostMapping("/queryUserList")
    @ApiOperation(value = "查询用户列表", position = 5)
    fun queryUserList(@RequestBody request: QueryUserListRequest): BaseResponse<ListResult<QueryUserListResponse>> {
        logger.info("查询用户列表入参:{}", ObjectMapper().writerWithDefaultPrettyPrinter()
                .writeValueAsString(request))
        val listResult = ListResult<QueryUserListResponse>()
        return BaseResponse.list("用户列表结果", listResult)
    }

}