export interface ProjectDtoApi {
  id:any;
  name : string;
  key : string;
  deadline : any;
}

export class ProjectDto implements ProjectDtoApi{
  constructor() {
  }
  id:any;
  deadline: any;
  key: string;
  name: string;
}

export interface UserDtoApi {
  email: string;
}

export class UserDto implements UserDtoApi{
  constructor() {
  }
  email: string;
}

export class TicketDtoApi{
  id:number;
  key:string;
  name:string;
  type:string;
  createUser:string;
  assignee:string;
  createDate:Date;
  deadline:Date;
  projectName:string;
  projectId:number;
  description:string;
}

export class TicketDto implements TicketDtoApi{
  constructor() {
  }
  id:number;
  key:string;
  name:string;
  type:string;
  createUser:string;
  assignee:string;
  createDate:Date;
  deadline:Date;
  projectName:string;
  projectId:number;
  description:string;
}
