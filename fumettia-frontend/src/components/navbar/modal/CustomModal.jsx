import React from 'react';
import { Formik, Form, Field, ErrorMessage } from 'formik';
import { useDispatch } from 'react-redux';
import '../../../styles/CustomModalStyle.css';
import { registrationValidationSchema, loginValidationSchema } from '../../../utility/ValidazioniForm';
import SitoImage from '../../../assets/CronoNerdImage.webp';
import { setUser } from '../../../store/slice/utenteSlice';
import { useLoginUtenteMutation, useRegistraUtenteMutation } from '../../../api/UtenteApi';

const CustomModal = ({ isOpen, onClose, content }) => {
    const dispatch = useDispatch(); 
    const [loginUtente] = useLoginUtenteMutation();
    const [registraUtente] = useRegistraUtenteMutation();

    const handleSubmitLogin = async (values, { resetForm }) => {
        const isEmail = values.usernameOrEmail.includes('@');
        const user = {
            [isEmail ? 'email' : 'username']: values.usernameOrEmail,
            password: values.password,
        };

        if (user.username || user.email) {
            try {
                const response = await loginUtente(user).unwrap();
                console.log('Login effettuato con successo:', response);
                dispatch(setUser(response));
            } catch (err) {
                console.error('Errore durante il login:', err);
            }
        }
        
        resetForm();
        onClose();
    };

    const handleSubmitRegistration = async (values, { resetForm }) => {
        const userForBackendDTO = {
            nome: values.nome,
            cognome: values.cognome,
            username: values.username,
            email: values.email,
            password: values.password,
        };

        if (userForBackendDTO.username && userForBackendDTO.email) {
            try {
                const response = await registraUtente(userForBackendDTO).unwrap();
                console.log('Registrazione avvenuta con successo:', response);
                dispatch(setUser(response)); // Popola lo stato dell'utente
            } catch (err) {
                console.error('Errore durante la registrazione:', err);
            }
        }
        
        resetForm();
        onClose();
    };

    if (!isOpen) return null;

    return (
        <div className="custom-modal-overlay">
            <div className="custom-modal-content" style={{
                backgroundImage: `url(${SitoImage})`,
                backgroundSize: 'cover',
                backgroundPosition: 'center',
                backgroundRepeat: 'no-repeat',
            }}>
                <button onClick={onClose} className="close-modal-button">
                    Chiudi
                </button>
                <div className="modal-body">
                    {content === 'ACCESSO' && (
                        <Formik
                            initialValues={{ usernameOrEmail: '', password: '' }}
                            validationSchema={loginValidationSchema}
                            onSubmit={handleSubmitLogin}
                        >
                            <Form>
                                <div className='input'>
                                    <label htmlFor="usernameOrEmail">Email o Username:</label>
                                    <Field
                                        type="text"
                                        id="usernameOrEmail"
                                        name="usernameOrEmail"
                                    />
                                    <ErrorMessage
                                        name="usernameOrEmail"
                                        component="div"
                                        className="error"
                                    />
                                </div>
                                <div className='input'>
                                    <label htmlFor="password">Password:</label>
                                    <Field
                                        type="password"
                                        id="password"
                                        name="password"
                                    />
                                    <ErrorMessage
                                        name="password"
                                        component="div"
                                        className="error"
                                    />
                                </div>
                                <button type="submit">Login</button>
                            </Form>
                        </Formik>
                    )}

                    {content === 'REGISTRAZIONE' && (
                        <Formik
                            initialValues={{
                                nome: '',
                                cognome: '',
                                username: '',
                                email: '',
                                password: '',
                            }}
                            validationSchema={registrationValidationSchema}
                            onSubmit={handleSubmitRegistration}
                        >
                            <Form>
                                <div className='input'>
                                    <label htmlFor="nome">Nome:</label>
                                    <Field type="text" id="nome" name="nome" />
                                    <ErrorMessage name="nome" component="div" className="error" />
                                </div>
                                <div className='input'>
                                    <label htmlFor="cognome">Cognome:</label>
                                    <Field type="text" id="cognome" name="cognome" />
                                    <ErrorMessage name="cognome" component="div" className="error" />
                                </div>
                                <div className='input'>
                                    <label htmlFor="username">Username:</label>
                                    <Field type="text" id="username" name="username" />
                                    <ErrorMessage name="username" component="div" className="error" />
                                </div>
                                <div className='input'>
                                    <label htmlFor="email">Email:</label>
                                    <Field type="email" id="email" name="email" />
                                    <ErrorMessage name="email" component="div" className="error" />
                                </div>
                                <div className='input'>
                                    <label htmlFor="password">Password:</label>
                                    <Field type="password" id="password" name="password" />
                                    <ErrorMessage name="password" component="div" className="error" />
                                </div>
                                <button type="submit">Registrati</button>
                            </Form>
                        </Formik>
                    )}
                </div>
            </div>
        </div>
    );
};

export default CustomModal;
