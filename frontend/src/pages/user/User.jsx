import React from 'react'
import "./user.css"
import { CalendarTodayOutlined, MailOutlineOutlined, PermIdentityOutlined, PhoneAndroidOutlined, PlaceOutlined, PublishOutlined } from '@mui/icons-material';
import { Link } from 'react-router-dom';

export default function User() {
    return (
        <div className='user'>
            <div className="userTitleContainer">
                <h1 className="userTitle">Edit User</h1>
                <Link to="/newUser">
                    <button className="userAddButton">Create</button>
                </Link>
            </div>
            <div className="userContainer">
                <div className="userShow">
                    <div className="userShowTop">
                        <img src="https://picsum.photos/seed/picsum/200/300" alt="" className="userShowImg" />
                        <div className="userShowTopTitle">
                            <span className="userShowUsername">Anna Becker</span>
                            <span className="userShowUserTitle">Software Developer</span>
                        </div>
                    </div>
                    <div className="userShowBottom">
                        <span className="userShowTitle">Account Details</span>
                        <div className="userShowInfo">
                            <PermIdentityOutlined className='userShowIcon' />
                            <span className="userShowInfoTitle">anabeck99</span>
                        </div>
                        <div className="userShowInfo">
                            <CalendarTodayOutlined className='userShowIcon' />
                            <span className="userShowInfoTitle">10.12.1999</span>
                        </div>
                        <span className="userShowTitle">Contact Details</span>
                        <div className="userShowInfo">
                            <PhoneAndroidOutlined className='userShowIcon' />
                            <span className="userShowInfoTitle">+1 123 456 67</span>
                        </div>
                        <div className="userShowInfo">
                            <MailOutlineOutlined className='userShowIcon' />
                            <span className="userShowInfoTitle">anabeck99@gmail.com</span>
                        </div>
                        <div className="userShowInfo">
                            <PlaceOutlined className='userShowIcon' />
                            <span className="userShowInfoTitle">Canada</span>
                        </div>
                    </div>
                </div>
                <div className="userUpdate">
                    <span className="userUpdateTitle">Edit</span>
                    <form className="userUpdateForm">
                        <div className="userUpdateLeft">
                            <div className="userUpdateItem">
                                <label>Username</label>
                                <input type="text" placeholder='anabeck99' className='userUpdateInput' />
                            </div>
                            <div className="userUpdateItem">
                                <label>Full name</label>
                                <input type="text" placeholder='anabeck99' className='userUpdateInput' />
                            </div>
                            <div className="userUpdateItem">
                                <label>Email</label>
                                <input type="text" placeholder='anabeck99' className='userUpdateInput' />
                            </div>
                            <div className="userUpdateItem">
                                <label>Phone</label>
                                <input type="text" placeholder='anabeck99' className='userUpdateInput' />
                            </div>
                            <div className="userUpdateItem">
                                <label>Address</label>
                                <input type="text" placeholder='anabeck99' className='userUpdateInput' />
                            </div>
                        </div>
                        <div className="userUpdateRight">
                            <div className="userUpdateUpload">
                                <img src="" alt="" className="userUpdateImg" />
                                <label htmlFor="file"><PublishOutlined className='userUpdateIcon' /></label>
                                <input type="file" id="file" style={{ display: "none" }} />
                            </div>
                            <button className="userUpdateButton">Update</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    )
}
