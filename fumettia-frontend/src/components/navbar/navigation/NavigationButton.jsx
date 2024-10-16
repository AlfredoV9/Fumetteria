import React from 'react';

const NavigationButton = ({ onClick, text }) => {
    return (
        <button className='navigationButton' onClick={onClick} >
            < span> {text}</span>
        </button >

    );
};

export default NavigationButton;
