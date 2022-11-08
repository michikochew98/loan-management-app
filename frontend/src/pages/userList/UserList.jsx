import React, { useState } from 'react';
import "./userList.css";
import { DataGrid } from '@mui/x-data-grid';
import { DeleteOutline } from '@mui/icons-material';
import { userRows } from '../../dummyData';
import { Link } from 'react-router-dom';

export default function UserList() {

    const [data, setData] = useState(userRows);

    const handleDelete = (id) => {
        setData(data.filter((item) => item.id !== id));
    };

    const columns = [
        { field: 'id', headerName: 'ID', width: 100 },
        {
            field: 'username',
            headerName: 'Username',
            width: 200,
            renderCell: (params) => (
                <div className='userListUser'>
                    <img className='userListImg' src={params.row.avatar} alt="" />
                    {params.row.username}
                </div>
            )
        },
        { field: 'email', headerName: 'Email', width: 200 },
        { field: 'status', headerName: 'Status', width: 140 },
        { field: 'transaction', headerName: 'Transaction Volume', width: 190 },
        {
            field: 'action',
            headerName: 'Action',
            width: 150,
            renderCell: (params) => (
                <>
                    <Link to={`/user/${params.row.id}`}>
                        <button className="userListEdit">Edit</button>
                    </Link>
                    <DeleteOutline className="userListDelete" onClick={() => handleDelete(params.row.id)}/>
                </>
            )
        },
    ];

    return (
        <div className='userList'>
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
