function handleMainPageButtons(button, title) {
	var buttons = $(button);
	buttons.on("click", function(event) {
		window.open(this.href, title, "height=400,width=550,menubar=0");
		event.preventDefault();
	});
}

function handlePopUpButtons(button, servlet) {
	var updateButton = $(button);
	
	updateButton.on("click", function(event) {
		event.preventDefault();
		$("#contact-form").attr("action", servlet);
		if(servlet == "UpdateContactServlet") {
			if(hasEmptyField(".input-field")) {
				$("p#error-message").show();
			} else {
				$("#contact-form").submit();
			}
		} else if (servlet == "DeleteContactServlet") {
			$("#contact-form").submit();
		}
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
	handleMainPageButtons(".view-contact-url", "View Contact");
	handleMainPageButtons("#create-button", "Create New Contact");
	handlePopUpButtons("#update-button", "UpdateContactServlet");
	handlePopUpButtons("#delete-button", "DeleteContactServlet");
});