/*
 * @Author: jackning 270580156@qq.com
 * @Date: 2024-07-17 11:35:47
 * @LastEditors: jackning 270580156@qq.com
 * @LastEditTime: 2025-01-09 22:46:50
 * @Description: bytedesk.com https://github.com/Bytedesk/bytedesk
 *   Please be aware of the BSL license restrictions before installing Bytedesk IM – 
 *  selling, reselling, or hosting Bytedesk IM as a service is a breach of the terms and automatically terminates your rights under the license.
 *  Business Source License 1.1: https://github.com/Bytedesk/bytedesk/blob/main/LICENSE 
 *  contact: 270580156@qq.com 
 *  联系：270580156@qq.com
 * Copyright (c) 2024 by bytedesk.com, All Rights Reserved. 
 */
package com.bytedesk.core.config;

// import org.springframework.context.ApplicationEvent;
// import org.springframework.core.ResolvableType;
// import org.springframework.core.ResolvableTypeProvider;

// // 通用型事件
// public class GenericApplicationEvent<T> extends ApplicationEvent implements ResolvableTypeProvider {
//     private T object;

//     public GenericApplicationEvent(Object source, T object) {
//         super(source);
//         this.object = object;
//     }

//     public T getObject() {
//         return object;
//     }

//     @Override
//     public ResolvableType getResolvableType() {
//         return ResolvableType.forClassWithGenerics(getClass(), ResolvableType.forInstance(object));
//     }
// }