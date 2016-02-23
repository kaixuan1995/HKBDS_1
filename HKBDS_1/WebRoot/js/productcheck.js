function check() {
	
	var objForm = document.forms[0];  //表示页面中出现的第1个form标签
	
	if (objForm.p_name.value.length == 0) {
		alert("产品名不能为空");
		return false;
	}
	if (objForm.p_image.value.length == 0) {
		alert("产品图片不能为空");
		return false;
	}
	if (objForm.p_image.value.length == 0) {
		alert("产品介绍不能为空");
		return false;
	}
	if (objForm.p_price.value.length == 0) {
		alert("产品价格不能为空");
		return false;
	}
	if (objForm.p_category.value.length == 0) {
		alert("产品类型不能为空");
		return false;
	}
}