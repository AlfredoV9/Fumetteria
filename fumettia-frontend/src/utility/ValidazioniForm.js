import * as Yup from 'yup';

// Regex per nome e cognome: lettere, apostrofi e spazi validi
const regexNomeCognome = /^(?=.{2,})([a-zA-ZÀ-ÖØ-öø-ÿ']+(?: [a-zA-ZÀ-ÖØ-öø-ÿ']+)*?)$/;

// Regex per password: almeno 8 caratteri, una maiuscola, una minuscola, un numero, un carattere speciale
const regexPassword = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

export const registrationValidationSchema = Yup.object({
    nome: Yup.string()
        .matches(regexNomeCognome, 'Nome non valido')
        .required('Il nome è obbligatorio'),
    cognome: Yup.string()
        .matches(regexNomeCognome, 'Cognome non valido')
        .required('Il cognome è obbligatorio'),
    username: Yup.string().required("L'username è obbligatorio"),
    email: Yup.string().email('Email non valida').required("L'email è obbligatoria"),
    password: Yup.string()
        .matches(
            regexPassword,
            'La password deve contenere almeno 8 caratteri, una lettera maiuscola, una minuscola, un numero e un carattere speciale'
        )
        .required('La password è obbligatoria'),
});

export const loginValidationSchema = Yup.object({
    usernameOrEmail: Yup.string().required('Inserisci Email o Username'),
    password: Yup.string().required('Inserisci la password'),
});
