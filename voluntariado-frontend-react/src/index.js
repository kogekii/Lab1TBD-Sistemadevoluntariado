import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import EmergencyPage from './pages/EmergencyPage';
import EmergencyDetailPage from './pages/EmergencyDetailPage';
import HomePages from './pages/HomePages';
import reportWebVitals from './reportWebVitals';
import {createBrowserRouter, RouterProvider,} from "react-router-dom";
const root = ReactDOM.createRoot(document.getElementById('root'));

const router = createBrowserRouter([
  {
    path: "/",
    element: <HomePages/>,
  },
  {
    path: "/emergency",
    children: [
      {
        path: "/emergency",
        element: <EmergencyPage/>
      },
      {
        path: "/emergency/:id",
        element: <EmergencyDetailPage/>
      }
    ]
  }
]);

root.render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
