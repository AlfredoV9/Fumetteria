import React from 'react';

function ModalButton({ onClick, text }) {
  return (
    <button
      onClick={onClick}
      style={{
        backgroundColor: '#E1058B',
        color: '#fff',
        border: 'none',
        padding: '10px 20px',
        borderRadius: '25px',
        cursor: 'pointer',
        fontSize: '16px',
        width: '40vw',
        marginBottom: "2.5vh"
      }}
    >
      {text}
    </button>
  );
}

export default ModalButton;
