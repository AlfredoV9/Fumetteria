// src/slices/utenteSlice.js
import { createSlice } from '@reduxjs/toolkit';

const utenteSlice = createSlice({
    name: 'utente',
    initialState: {}, // Inizializza come oggetto vuoto
    reducers: {
        setUser: (state, action) => {
            return { ...action.payload }; // Popola lo stato con i dati dell'utente
        },
        clearUser: () => {
            return {}; // Resetta lo stato a oggetto vuoto
        },
    },
});

// Esporta le azioni e il riduttore
export const { setUser, clearUser } = utenteSlice.actions;
export default utenteSlice.reducer;
