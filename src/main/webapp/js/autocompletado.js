// autocompletado.js

function initAutocomplete() {
    var input = document.getElementById('Direccion');
    var autocomplete = new google.maps.places.Autocomplete(input);
}

window.onload = function() {
    initAutocomplete();
};
