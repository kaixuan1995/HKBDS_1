function check() {
	
	var objForm = document.forms[1];  //��ʾҳ���г��ֵĵڶ���form��ǩ
	
	if (objForm.username.value.length == 0) {
		alert("�û�������Ϊ��");
		return false;
	}

	if (objForm.title.value.length == 0) {
		alert("�������ⲻ��Ϊ��");
		return false;
	}

	if (objForm.email.value.length == 0) {
		alert("email����Ϊ��");
		return false;
	}
	
	if (objForm.email.value != "") {
		var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
		isok = reg.test(objForm.email.value);
		if (!isok) {
			alert("�����ʽ����ȷ�����������룡");
			//document.getElementById("emailname").focus();
			return false;
		}
	}
	
	if (objForm.address.value.length == 0) {
		alert("��ַ����Ϊ��");
		return false;
	}
	
	if (objForm.message.value.length == 0) {
		alert("�������ݲ���Ϊ��");
		return false;
	}
	
}