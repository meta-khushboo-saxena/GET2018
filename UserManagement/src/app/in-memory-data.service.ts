import { InMemoryDbService } from 'angular-in-memory-web-api';
import { User } from './user';

export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const users = [
      { id: 11, name: 'Khushboo', city: 'jaipur' , contact : 637424872 },
      { id: 12, name: 'Nikhil', city: 'jaipur' , contact : 6374248724  },
      { id: 13, name: 'Arjita', city: 'jaipur' , contact : 6374248724  },
      { id: 14, name: 'Richa', city: 'jaipur' , contact : 6374248724  }
    ];
    return {users};
  }
  
  genId(users: User[]): number {
    return users.length > 0 ? Math.max(...users.map(user => user.id)) + 1 : 11;
  }
}
