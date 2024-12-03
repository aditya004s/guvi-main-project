// Form validation and interactivity

document.addEventListener('DOMContentLoaded', function() {
    const loginForm = document.getElementById('loginForm');
    const registerForm = document.getElementById('registerForm');
    const profileForm = document.getElementById('profileForm');
    const bookingForm = document.getElementById('bookingForm');

    if (loginForm) {
        loginForm.addEventListener('submit', function(e) {
            e.preventDefault();
            if (validateLoginForm()) {
                alert('Login successful!');
                // Redirect to user profile or dashboard
            }
        });
    }

    if (registerForm) {
        registerForm.addEventListener('submit', function(e) {
            e.preventDefault();
            if (validateRegisterForm()) {
                alert('Registration successful!');
                // Redirect to login page or dashboard
            }
        });
    }

    if (profileForm) {
        profileForm.addEventListener('submit', function(e) {
            e.preventDefault();
            if (validateProfileForm()) {
                alert('Profile updated successfully!');
            }
        });
    }

    if (bookingForm) {
        bookingForm.addEventListener('submit', function(e) {
            e.preventDefault();
            if (validateBookingForm()) {
                alert('Booking successful!');
                // Redirect to booking confirmation page
            }
        });
    }
});

function validateLoginForm() {
    const email = document.getElementById('email');
    const password = document.getElementById('password');
    let isValid = true;

    if (!isValidEmail(email.value)) {
        setInvalid(email, 'Please enter a valid email address.');
        isValid = false;
    } else {
        setValid(email);
    }

    if (password.value.length < 6) {
        setInvalid(password, 'Password must be at least 6 characters long.');
        isValid = false;
    } else {
        setValid(password);
    }

    return isValid;
}

function validateRegisterForm() {
    const fullName = document.getElementById('fullName');
    const email = document.getElementById('email');
    const password = document.getElementById('password');
    const confirmPassword = document.getElementById('confirmPassword');
    let isValid = true;

    if (fullName.value.trim() === '') {
        setInvalid(fullName, 'Please enter your full name.');
        isValid = false;
    } else {
        setValid(fullName);
    }

    if (!isValidEmail(email.value)) {
        setInvalid(email, 'Please enter a valid email address.');
        isValid = false;
    } else {
        setValid(email);
    }

    if (!isStrongPassword(password.value)) {
        setInvalid(password, 'Password must be at least 8 characters long and include uppercase, lowercase, number, and special character.');
        isValid = false;
    } else {
        setValid(password);
    }

    if (password.value !== confirmPassword.value) {
        setInvalid(confirmPassword, 'Passwords do not match.');
        isValid = false;
    } else {
        setValid(confirmPassword);
    }

    return isValid;
}

function validateProfileForm() {
    const fullName = document.getElementById('fullName');
    const email = document.getElementById('email');
    const phone = document.getElementById('phone');
    const address = document.getElementById('address');
    let isValid = true;

    if (fullName.value.trim() === '') {
        setInvalid(fullName, 'Please enter your full name.');
        isValid = false;
    } else {
        setValid(fullName);
    }

    if (!isValidEmail(email.value)) {
        setInvalid(email, 'Please enter a valid email address.');
        isValid = false;
    } else {
        setValid(email);
    }

    if (!isValidPhone(phone.value)) {
        setInvalid(phone, 'Please enter a valid phone number.');
        isValid = false;
    } else {
        setValid(phone);
    }

    if (address.value.trim() === '') {
        setInvalid(address, 'Please enter your address.');
        isValid = false;
    } else {
        setValid(address);
    }

    return isValid;
}

function validateBookingForm() {
    const carModel = document.getElementById('carModel');
    const pickupDate = document.getElementById('pickupDate');
    const returnDate = document.getElementById('returnDate');
    const pickupLocation = document.getElementById('pickupLocation');
    const returnLocation = document.getElementById('returnLocation');
    let isValid = true;

    if (carModel.value === '') {
        setInvalid(carModel, 'Please select a car model.');
        isValid = false;
    } else {
        setValid(carModel);
    }

    if (pickupDate.value === '') {
        setInvalid(pickupDate, 'Please select a pickup date.');
        isValid = false;
    } else {
        setValid(pickupDate);
    }

    if (returnDate.value === '') {
        setInvalid(returnDate, 'Please select a return date.');
        isValid = false;
    } else if (new Date(returnDate.value) <= new Date(pickupDate.value)) {
        setInvalid(returnDate, 'Return date must be after pickup date.');
        isValid = false;
    } else {
        setValid(returnDate);
    }

    if (pickupLocation.value.trim() === '') {
        setInvalid(pickupLocation, 'Please enter a pickup location.');
        isValid = false;
    } else {
        setValid(pickupLocation);
    }

    if (returnLocation.value.trim() === '') {
        setInvalid(returnLocation, 'Please enter a return location.');
        isValid = false;
    } else {
        setValid(returnLocation);
    }

    return isValid;
}

function isValidEmail(email) {
    const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return re.test(email);
}

function isStrongPassword(password) {
    const re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}$/;
    return re.test(password);
}

function isValidPhone(phone) {
    const re = /^\d{3}-\d{3}-\d{4}$/;
    return re.test(phone);
}

function setInvalid(element, message) {
    element.classList.add('is-invalid');
    element.nextElementSibling.textContent = message;
}

function setValid(element) {
    element.classList.remove('is-invalid');
    element.nextElementSibling.textContent = '';
}

// Add real-time validation for password strength
if (document.getElementById('password')) {
    document.getElementById('password').addEventListener('input', function() {
        const password = this.value;
        const strengthMeter = document.createElement('div');
        strengthMeter.className = 'password-strength-meter mt-2';
        
        if (!this.nextElementSibling.classList.contains('password-strength-meter')) {
            this.parentNode.insertBefore(strengthMeter, this.nextElementSibling);
        } else {
            strengthMeter = this.nextElementSibling;
        }

        if (password.length === 0) {
            strengthMeter.textContent = '';
        } else if (password.length < 8) {
            strengthMeter.textContent = 'Weak';
            strengthMeter.style.color = 'red';
        } else if (isStrongPassword(password)) {
            strengthMeter.textContent = 'Strong';
            strengthMeter.style.color = 'green';
        } else {
            strengthMeter.textContent = 'Medium';
            strengthMeter.style.color = 'orange';
        }
    });
}

// Add date validation for booking form
if (document.getElementById('pickupDate') && document.getElementById('returnDate')) {
    document.getElementById('pickupDate').addEventListener('change', validateDates);
    document.getElementById('returnDate').addEventListener('change', validateDates);
}

function validateDates() {
    const pickupDate = new Date(document.getElementById('pickupDate').value);
    const returnDate = new Date(document.getElementById('returnDate').value);
    const today = new Date();
    today.setHours(0, 0, 0, 0);

    if (pickupDate < today) {
        setInvalid(document.getElementById('pickupDate'), 'Pickup date cannot be in the past.');
    } else {
        setValid(document.getElementById('pickupDate'));
    }

    if (returnDate <= pickupDate) {
        setInvalid(document.getElementById('returnDate'), 'Return date must be after pickup date.');
    } else {
        setValid(document.getElementById('returnDate'));
    }
}

// Add interactivity to car listing page
if (document.querySelector('.card')) {
    document.querySelectorAll('.card').forEach(card => {
        card.addEventListener('mouseenter', function() {
            this.style.boxShadow = '0 4px 8px rgba(0,0,0,0.2)';
        });
        card.addEventListener('mouseleave', function() {
            this.style.boxShadow = 'none';
        });
    });
}

// Implement a simple search functionality on the car listing page
if (document.getElementById('carSearch')) {
    document.getElementById('carSearch').addEventListener('input', function() {
        const searchTerm = this.value.toLowerCase();
        document.querySelectorAll('.card').forEach(card => {
            const carName = card.querySelector('.card-title').textContent.toLowerCase();
            if (carName.includes(searchTerm)) {
                card.style.display = 'block';
            } else {
                card.style.display = 'none';
            }
        });
    });
}