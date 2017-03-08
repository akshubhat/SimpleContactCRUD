function handleMainPageButtons(button, title) {
	var buttons = $(button);
	buttons.on("click", function(event) {
		window.open(this.href, title, "height=400,width=550,menubar=0");
		event.preventDefault();
	});
}

$(document).ready(function() {
	handleMainPageButtons(".view-button", "View Contact");
	handleMainPageButtons(".create-button", "Create New Contact");
});