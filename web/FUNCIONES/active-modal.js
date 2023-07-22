/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
const btnMenu=document.querySelector('.btn-menu');

btnMenu.addEventListener('click', ()=>{
    document.querySelector('.ds-left-menu').classList.toggle('menu-active');
    document.querySelector('.ds-panel').classList.toggle('tab-menu');
});

