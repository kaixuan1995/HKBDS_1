function check() {
	
	var objForm = document.forms[0];  //��ʾҳ���г��ֵĵ�1��form��ǩ
	
	if (objForm.p_name.value.length == 0) {
		alert("��Ʒ������Ϊ��");
		return false;
	}
	if (objForm.p_image.value.length == 0) {
		alert("��ƷͼƬ����Ϊ��");
		return false;
	}
	if (objForm.p_image.value.length == 0) {
		alert("��Ʒ���ܲ���Ϊ��");
		return false;
	}
	if (objForm.p_price.value.length == 0) {
		alert("��Ʒ�۸���Ϊ��");
		return false;
	}
	if (objForm.p_category.value.length == 0) {
		alert("��Ʒ���Ͳ���Ϊ��");
		return false;
	}
}