import React, { useState } from 'react';
import './productList.css';
import { DataGrid } from '@mui/x-data-grid';
import { DeleteOutline } from '@mui/icons-material';
import { productRows } from '../../dummyData';
import { Link } from 'react-router-dom';

export default function ProductList() {

    const [data, setData] = useState(productRows);

    const handleDelete = (id) => {
        setData(data.filter((item) => item.id !== id));
    };

    const columns = [
        { field: 'id', headerName: 'ID', width: 100 },
        {
            field: 'name',
            headerName: 'Name',
            width: 200,
            renderCell: (params) => (
                <div className='productListItem'>
                    <img className='productListImg' src={params.row.img} alt="" />
                    {params.row.name}
                </div>
            )
        },
        { field: 'stock', headerName: 'Stock', width: 200 },
        { field: 'status', headerName: 'Status', width: 140 },
        { field: 'price', headerName: 'Price', width: 190 },
        {
            field: 'action',
            headerName: 'Action',
            width: 150,
            renderCell: (params) => (
                <>
                    <Link to={`/product/${params.row.id}`}>
                        <button className="productListEdit">Edit</button>
                    </Link>
                    <DeleteOutline className="productListDelete" onClick={() => handleDelete(params.row.id)} />
                </>
            )
        },
    ];
    return (
        <div className='productList'>
            <DataGrid
                rows={data}
                columns={columns}
                pageSize={5}
                rowsPerPageOptions={[5]}
                checkboxSelection
                disableSelectionOnClick
            />
        </div>
    )
}
