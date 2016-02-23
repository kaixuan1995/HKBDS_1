function check() {
	
	var objForm = document.forms[1];  //表示页面中出现的第二个form标签
	
	if (objForm.username.value.length == 0) {
		alert("用户名不能为空");
		return false;
	}

	if (objForm.title.value.length == 0) {
		alert("留言主题不能为空");
		return false;
	}

	if (objForm.email.value.length == 0) {
		alert("email不能为空");
		return false;
	}
	
	if (objForm.email.value != "") {
		var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
		isok = reg.test(objForm.email.value);
		if (!isok) {
			alert("邮箱格式不正确，请重新输入！");
			//document.getElementById("emailname").focus();
			return false;
		}
	}
	
	if (objForm.address.value.length == 0) {
		alert("地址不能为空");
		return false;
	}
	
	if (objForm.message.value.length == 0) {
		alert("留言内容不能为空");
		return false;
	}
	
}