function handleViewButton() {
	var viewButton = $(".view-contact-url");
	viewButton.on("click", function(event) {
		window.open(this.href, "View Contact", "height=400,width=550,menubar=0");
		event.preventDefault();
	});
}

function handleUpdateButton() {
	var updateButton = $("#update-button");
	
	updateButton.on("click", function(event) {
		event.preventDefault();
		$("#contact-form").attr("action", "UpdateServlet");
		if(hasEmptyField(".input-field")) {
			$("p#error-message").show();
		} else {
			$("#contact-form").submit();
		}
	});
}

function handleDeleteButton() {
	
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
	handleViewButton();
	handleUpdateButton();
});