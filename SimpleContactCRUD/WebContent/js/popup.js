function handleUpdateButton() {
	$(".update-button").on("click", function (event) {
		event.preventDefault();
		$(".contact-form").attr("action", "UpdateContactServlet");
		if(hasEmptyField(".input-field"))
			$(".error-message").show();
		else
			$(".contact-form").submit();
	});
}

function handleDeleteButton() {
	$(".delete-button").on("click", function (event) {
		event.preventDefault();
		$(".contact-form").attr("action", "DeleteContactServlet");
		$(".contact-form").submit();
	});
}

function handleCreateButton() {
	$(".create-button").on("click", function (event) {
		event.preventDefault();
		if(hasEmptyField(".input-field"))
			$(".error-message").show();
		else
			$(".contact-form").submit();
	});
}

function handleCancelButton() {
	$(".cancel-button").on("click", function () {
		event.preventDefault();
		window.close();
	});
}

function hasEmptyField(inputField) {
	var emptyField = false;
	$(inputField).each(function () {
		if($(this).val() == "") {
			emptyField = true;
		}
	});
	return emptyField;
}


$(document).ready(function() {
	/* update contact page */
	handleUpdateButton();
	handleDeleteButton();
	
	/* create contact page */
	handleCreateButton();
	handleCancelButton();
});