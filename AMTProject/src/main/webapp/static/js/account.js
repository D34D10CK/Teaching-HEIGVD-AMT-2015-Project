if (document.readyState !== 'loading') {
    run()
} else {
    document.addEventListener('DOMContentLoaded', run)
}

function run() {
    document.querySelector("#menu-account-link").classList.add('active');
}