function handleViewButton() {
	var viewButton = $(".view-contact-url");
	viewButton.on("click", function(event) {
		window.open(this.href, "View Contact", "height=400,width=550,menubar=0");
		event.preventDefault();
	});
}

$(document).ready(function() {
	handleViewButton();
});