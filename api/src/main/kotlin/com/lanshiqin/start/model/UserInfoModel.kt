package com.lanshiqin.start.model

import io.swagger.annotations.ApiModelProperty

class AddUserRequest{
    @ApiModelProperty(value= "姓名")
    var name: String ?= null
}

class DeleteUserRequest{
    @ApiModelProperty(value= "用户id")
    var userId: String ?= null
}

class UpdateUserRequest{
    @ApiModelProperty(value= "用户id")
    var userId: String ?= null
    @ApiModelProperty(value= "姓名")
    var name: String ?= null
}

class QueryUserByIdRequest{
    @ApiModelProperty(value= "用户id")
    var userId: String ?= null
    @ApiModelProperty(value= "姓名")
    var name: String ?= null
}

class QueryUserByIdResponse{
    @ApiModelProperty(value= "用户id")
    var userId: String ?= null
}

class QueryUserListRequest{
    @ApiModelProperty(value= "姓名")
    var name: String ?= null
}

class QueryUserListResponse{
    @ApiModelProperty(value= "用户id")
    var userId: String ?= null
    @ApiModelProperty(value= "姓名")
    var name: String ?= null
}