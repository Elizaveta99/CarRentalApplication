    const leaveRequestForm = {
        model: {
            label: 'Модель',
            type: 'text',
            class: 'form-control',
            placeholder: 'Введите модель',
            name: 'model',
            id: 'model_input',
        },
        rental_time: {
            label: 'Время аренды (в днях)',
            type: 'number',
            class: 'form-control',
            placeholder: 'Введите время аренды',
            name: 'rental_time',
            minValue: '1',
            step: '1',
            id: 'rental_time_input',
        },
        id_passport: {
            label: 'ID клиента',
            type: 'text',
            class: 'form-control',
            placeholder: 'Введите ID клиента',
            name: 'id_passport',
            id: 'id_passport_input',
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: 'ok'
        }
    };

    const carsByModelForm = {
        model: {
            label: 'Модель',
            type: 'text',
            class: 'form-control',
            placeholder: 'Введите модель',
            name: 'model',
            id: 'model_input',
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: 'ok'
        }
    };

    const handleRequestForm = {
        request_id: {
            label: 'ID заявки',
            type: 'text',  //?? number
            class: 'form-control',
            placeholder: 'Введите ID заявки',
            name: 'request_id',
            id: 'request_id_input',
        },
        car_id: {
            label: 'ID автомобиля',
            type: 'text',  //?? number
            class: 'form-control',
            placeholder: 'Введите ID автомобиля',
            name: 'car_id',
            id: 'car_id_input',
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: 'ok'
        }
    };

    const returnCarForm = {
        car_id: {
            label: 'ID автомобиля',
            type: 'text',  //?? number
            class: 'form-control',
            placeholder: 'Введите ID автомобиля',
            name: 'car_id',
            id: 'car_id_input',
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: 'ok'
        }
    };

    const loginForm = {
        login_text: {
            label: 'Логин',
            type: 'text',
            class: 'form-control',
            placeholder: 'Введите логин',
            name: 'login_text',
            id: 'login_text_input',
        },
        password_text: {
            label: 'Пароль',
            type: 'text',
            class: 'form-control',
            placeholder: 'Введите пароль',
            name: 'password_text',
            id: 'password_text_input',
        },
        type_text: {
            label: 'Тип(admin/user/guest)',
            type: 'text',
            class: 'form-control',
            placeholder: 'Введите тип',
            name: 'type_text',
            id: 'type_text_input',
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: 'ok'
        }
    };

    const registerForm = {
        login_text: {
            label: 'Логин',
            type: 'text',  //?? number
            class: 'form-control',
            placeholder: 'Введите логин',
            name: 'login_text',
            id: 'login_text_input',
        },
        password_text: {
            label: 'Пароль',
            type: 'text',  //?? number
            class: 'form-control',
            placeholder: 'Введите пароль',
            name: 'password_text',
            id: 'password_text_input',
        },
        name_text: {
            label: 'Имя',
            type: 'text',  //?? number
            class: 'form-control',
            placeholder: 'Введите имя',
            name: 'name_text',
            id: 'name_text_input',
        },
        number_text: {
            label: 'Номер телефона',
            type: 'text',  //?? number
            class: 'form-control',
            placeholder: 'Введите номер телефона',
            name: 'number_text',
            id: 'number_text_input',
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: 'ok'
        }
    };


    function showError() {
        var model = document.getElementById('model_input');
        var modelError = document.getElementById('error_id_model');
        modelError.textContent = `Model can't be less than 4 letters; you entered ${ model.value.length }.`;
        modelError.className = 'error active';
    }

    function showErrorTime() {
        var model = document.getElementById('rental_time_input');
        var modelError = document.getElementById('error_id_time');
        modelError.textContent = `Time can't be less than 5 days; you entered ${ model.value }.`;
        modelError.className = 'error active';
    }

    function showErrorId() {
        var model = document.getElementById('id_passport_input');
        var modelError = document.getElementById('error_id_id');
        modelError.textContent = `ID_PASSPORT can't be less than 9 letters; you entered ${ model.value.length }.`;
        modelError.className = 'error active';
    }


    function validateModel(inputElement) {
        const value = inputElement.value;
        if (value.length < 4) {
            console.log('validateModel')
            showError();
            return false;
        } else {
            var model = document.getElementById('model_input');
            var modelError = document.getElementById('error_id_model');
            modelError.textContent = ``;
            return true;
        }
    }

    function validateTime(inputElement) {
        const value = inputElement.value;
        if (value < 10) {
            console.log('validateTime')
            showErrorTime();
            return false;
        } else {
            var model = document.getElementById('rental_time_input');
            var modelError = document.getElementById('error_id_time');
            modelError.textContent = ``;
            return true;
        }
    }

    function validateId(inputElement) {
        const value = inputElement.value;
        if (value.length < 9) {
            console.log('validateId')
            showErrorId();
            return false;
        } else {
            var model = document.getElementById('id_passport_input');
            var modelError = document.getElementById('error_id_id');
            modelError.textContent = ``;
            return true;
        }
    }

    function buildForm(form, type) {
        var array;
        switch (type) {
            case 'leaveRequestForm':
                array = leaveRequestForm;
                break;
            case 'carsByModelForm':
                array = carsByModelForm;
                break;
            case 'handleRequestForm':
                array = handleRequestForm;
                break;
            case 'returnCarForm':
                array = returnCarForm;
                break;
            case 'loginForm':
                array = loginForm;
                break;
            case 'registerForm':
                array = registerForm;
                break;
        }

        for(var property in array) {
            var input = document.createElement('input');
            switch (array[property].type) {
                default:
                    var formDiv = document.createElement('div');
                    formDiv.setAttribute('class', 'form-group');

                    var label = document.createElement('label');
                    label.innerHTML = array[property].label;
                    var label_error = document.createElement('label');
                    label.appendChild(label_error);
                    formDiv.appendChild(label);


                    input.setAttribute('type', array[property].type);
                    input.setAttribute('class', array[property].class);
                    input.setAttribute('placeholder', array[property].placeholder);
                    input.setAttribute('name', array[property].name);
                    input.setAttribute("id", array[property].id);
                    if (input.id == 'model_input') {
                        label_error.setAttribute('id', 'error_id_model');
                        label_error.innerHTML = '';
                        input.addEventListener('input', function(evt) {
                            validateModel(evt.target);
                        });
                    }

                    if (input.id == 'rental_time_input') {
                        label_error.setAttribute('id', 'error_id_time');
                        label_error.innerHTML = '';
                        input.addEventListener('input', function(evt) {
                            validateTime(evt.target);
                        });
                    }

                    if (input.id == 'id_passport_input') {
                        label_error.setAttribute('id', 'error_id_id');
                        label_error.innerHTML = '';
                        input.addEventListener('input', function(evt) {
                            validateId(evt.target);
                        });
                    }

                    input.required = true;
                    formDiv.appendChild(input);

                    form.appendChild(formDiv);
                    break;
                case "submit":
                    var submit = document.createElement('button');
                    submit.setAttribute('class', array[property].class);
                    submit.textContent = array[property].value;
                    submit.onclick = onSubmit

                    form.appendChild(submit);
                    break;
                case "rental_time":
                    input.setAttribute('minValue', array[property].minValue);
                    input.setAttribute('step', array[property].step);
            }
        }
    }


    function createForm() {

        var leaveRequestForm = document.getElementById('leave_request_form');
        if (leaveRequestForm != null) {
            buildForm(leaveRequestForm, 'leaveRequestForm');
            console.log('leaveRequestForm');
            formId = 'leave_request_form';
            return
        }

        var carsByModelForm = document.getElementById('cars_by_model_form');
        if (carsByModelForm != null) {
            buildForm(carsByModelForm, 'carsByModelForm');
            console.log('carsByModelForm');
            formId = 'cars_by_model_form';
            return
        }
        var handleRequestForm = document.getElementById('handle_request_form');
        if (handleRequestForm != null) {
            buildForm(handleRequestForm, 'handleRequestForm');
            console.log('handleRequestForm');
            formId = 'handle_request_form';
            return
        }

        var returnCarForm = document.getElementById('return_car_form');
        if (returnCarForm != null) {
            buildForm(returnCarForm, 'returnCarForm');
            console.log('returnCarForm');
            formId = 'return_car_form';
            return
        }

        var loginForm = document.getElementById('login_form');
        if (loginForm != null) {
            buildForm(loginForm, 'loginForm');
            console.log('loginForm');
            formId = 'login_form';
            return
        }

        var registerForm = document.getElementById('register_form');
        if (registerForm != null) {
            buildForm(registerForm, 'registerForm');
            console.log('registerForm');
            formId = 'register_form';
            return
        }
    }


    function onSubmit() {
        console.log('submit')
        validateModel(document.getElementById('model_input'))
    }

    createForm();
