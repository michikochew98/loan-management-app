import React from 'react';
import './newProduct.css';
import { PublishOutlined } from '@mui/icons-material';

export default function NewProduct() {
    return (
        <div className='newProduct'>
            <h1 className="addProductTitle">New Product</h1>
            <form className="addProductForm">
                <div className="addProductItem">
                    <label>Image</label>
                    <input type="file" id='file' />
                </div>
                <div className="addProductItem">
                    <label>Name</label>
                    <input type="text" id='apple ipod' />
                </div>
                <div className="addProductItem">
                    <label>Stock</label>
                    <input type="text" id='123' />
                </div>
                <div className="addProductItem">
                    <label>Active</label>
                    <select name="active" id="active">
                        <option value="yes">Yes</option>
                        <option value="no">No</option>
                    </select>
                </div>
                <button className="addProductButton">Create</button>
            </form>
        </div>
    )
}
