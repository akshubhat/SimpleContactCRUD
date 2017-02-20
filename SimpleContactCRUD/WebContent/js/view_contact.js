function handleUpdateButton() {
	var updateButton = $("#update-button");
	
	updateButton.on("click", function(event) {
		event.preventDefault();
		if(hasEmptyField(".input-field")) {
			$("p#error-message").show();
		} else {
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

$(document).ready(function () {
	handleUpdateButton();
});