<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<!--外层的div-->
<div class="modal fade" id="updatePassModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <form role="form" class="form-horizontal"  action="${pageContext.request.contextPath }/users/updatepwd" onsubmit="return check()">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h2 class="modal-title">修改密码</h2>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-md-2 control-label">原密码</label>
                        <div class="col-md-8">
                            <div class="input-group">
									<span class="input-group-addon">
										<i class="fa fa-key"></i>
									</span>
                                <input type="password" class="form-control1" id="oldpass" placeholder="请输入原密码">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">新密码</label>
                        <div class="col-md-8">
                            <div class="input-group">
									<span class="input-group-addon">
										<i class="fa fa-key"></i>
									</span>
                                <input type="password" class="form-control1" name="password" id="newpass1" placeholder="请输入新密码">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">确认密码</label>
                        <div class="col-md-8">
                            <div class="input-group">
									<span class="input-group-addon">
										<i class="fa fa-key"></i>
									</span>
                                <input type="password" class="form-control1" id="newpass2" placeholder="请输入确认密码">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">保存</button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<script>
    function check(){
        if($("#oldpass").val()!='${userSession.password}'){
            alert("原密码错误");
            return false;
        }else if($("#newpass1").val()!=$("#newpass2").val()){
            alert("两次密码不一致");
            return false;
        }else{
            return true;
        }
    }

</script>
</body>
</html>