if (document.readyState !== 'loading') {
    run()
} else {
    document.addEventListener('DOMContentLoaded', run)
}

function run() {
    document.querySelector("#menu-apps-link").classList.add('active');

    var enableButtons = document.querySelectorAll('.enable-button');

    [].forEach.call(enableButtons, function (button) {
        button.addEventListener('click', buttonListener);
    });

    function buttonListener(event) {
        var btn = event.target;
        var id = btn.getAttribute('data-id');
        var isEnable = btn.getAttribute('data-is-enable') === "true";

        if (isEnable) {
            btn.setAttribute('data-is-enable', 'false');
            btn.classList.remove('btn-success');
            btn.classList.add('btn-danger');
            btn.innerText = "Disable";
            console.log(id);
            fetch('/app-details?action=disable&appId=' + id)
                .then(function(response) {
                    console.log(response.text());
                })
        } else {
            btn.setAttribute('data-is-enable', 'true');
            btn.classList.remove('btn-danger');
            btn.classList.add('btn-success');
            btn.innerText = "Enable";
            fetch('/app-details?action=enable&appId=' + id)
                .then(function(response) {
                    console.log(response.text());
                })
        }
    }
}