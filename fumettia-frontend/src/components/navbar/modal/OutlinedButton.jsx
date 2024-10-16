import React from 'react';

const OutlinedButton = ({ onClick, text, icon, section }) => {
    return (
        <button className='outlinedButton' onClick={onClick} >
            {section ?
                <>
                    {icon}
                </>
                :
                <>
                </>
            }
            < span className='buttonText' > {text}</span>
        </button >

    );
};

export default OutlinedButton;
