import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";
import {
    BASE_URL,
    LOGIN,
    REGISTER
} from "../utility/apiConstants";

export const UtenteApi = createApi({
    reducerPath: "utenteApi",
    baseQuery: fetchBaseQuery({
        baseUrl: BASE_URL,
        prepareHeaders: (headers) => {
            headers.set("Access-Control-Allow-Origin", "*");
            return headers;
        },
    }),
    tagTypes: ["Utente"],
    endpoints: (builder) => ({
        registraUtente: builder.mutation({
            query: (utenteForBackEndDTO) => ({
                url: REGISTER,
                method: "POST",
                body: utenteForBackEndDTO,
            }),
            invalidatesTags: ["Utente"],
        }),
        loginUtente: builder.mutation({
            query: (utenteForBackEndDTO) => ({
                url: LOGIN,
                method: "POST",
                body: utenteForBackEndDTO,
            }),
        }),
    }),
});

export const {
    useLoginUtenteMutation,
    useRegistraUtenteMutation
} = UtenteApi;
