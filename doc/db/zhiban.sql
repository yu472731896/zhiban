
# 添加菜单 by minghui  20180426
INSERT INTO `zhiban`.`sys_menu` (`id`, `parent_id`, `parent_ids`, `name`, `sort`, `href`, `target`, `icon`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('d4f12fa18ce140c0b7e9a9371ca29506', '77bd5f31e41b4452a858ec86084d9de2', '0,1,cdabd97f12f244da916fc4195ade202b,0a59fd2ff2cf42a79ec4241435002ccf,77bd5f31e41b4452a858ec86084d9de2,', '编辑', '60', '', '', '', '0', 'base:baseUserInfo:edit', '1', '2018-04-17 13:29:13', '1', '2018-04-17 13:29:13', '', '0');
INSERT INTO `zhiban`.`sys_menu` (`id`, `parent_id`, `parent_ids`, `name`, `sort`, `href`, `target`, `icon`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('41ca320df3d849d3af0f876f5cb08377', '77bd5f31e41b4452a858ec86084d9de2', '0,1,cdabd97f12f244da916fc4195ade202b,0a59fd2ff2cf42a79ec4241435002ccf,77bd5f31e41b4452a858ec86084d9de2,', '查看', '30', '', '', '', '0', 'base:baseUserInfo:view', '1', '2018-04-17 13:28:58', '1', '2018-04-17 13:28:58', '', '0');
INSERT INTO `zhiban`.`sys_menu` (`id`, `parent_id`, `parent_ids`, `name`, `sort`, `href`, `target`, `icon`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('77bd5f31e41b4452a858ec86084d9de2', '0a59fd2ff2cf42a79ec4241435002ccf', '0,1,cdabd97f12f244da916fc4195ade202b,0a59fd2ff2cf42a79ec4241435002ccf,', '用户基本信息', '120', '/base/baseUserInfo/list', '', '', '1', '', '1', '2018-04-17 13:28:38', '1', '2018-04-17 13:28:38', '', '0');
INSERT INTO `zhiban`.`sys_menu` (`id`, `parent_id`, `parent_ids`, `name`, `sort`, `href`, `target`, `icon`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('de499095f74249259e9fc83f502dc2b5', 'c5d0f6c23c234772a3dae9029159b032', '0,1,cdabd97f12f244da916fc4195ade202b,c5d0f6c23c234772a3dae9029159b032,', '看我的名片', '30', '/manage/myView', '', '', '1', '', '1', '2018-04-17 11:22:02', '1', '2018-04-17 11:40:47', '', '0');
INSERT INTO `zhiban`.`sys_menu` (`id`, `parent_id`, `parent_ids`, `name`, `sort`, `href`, `target`, `icon`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('c5d0f6c23c234772a3dae9029159b032', 'cdabd97f12f244da916fc4195ade202b', '0,1,cdabd97f12f244da916fc4195ade202b,', '我的名片', '5030', '', '', '', '1', '', '1', '2018-04-17 11:15:31', '1', '2018-04-17 11:21:22', '', '0');

# 修改index 字段名为 index_str by minghui  20180427
ALTER TABLE `base_introduce`
CHANGE COLUMN `index` `index_str`  varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '顺序' AFTER `tital`;

ALTER TABLE `base_turn_picture`
CHANGE COLUMN `index` `index_str`  varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '顺序 ' AFTER `del_flag`;

-----------------------------------------------------------------------------------
#角色表添加 普通用户
INSERT INTO `zhiban`.`sys_role` (`id`, `office_type`, `office_id`, `name`, `enname`, `role_type`, `data_scope`, `is_sys`, `useable`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES ('2', NULL, '1', '普通用户', 'user', 'user', '8', '1', '1', '1', '2018-05-15 08:44:40', '1', '2018-05-15 08:44:40', '', '0');
ALTER TABLE `sys_user`
MODIFY COLUMN `name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '姓名' AFTER `no`;



