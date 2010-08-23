package lets.code.better.todo.util;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.resource.ResourceMethod;

@RequestScoped
@Intercepts
public class TransactionInterceptor implements Interceptor {

	@Override
	public boolean accepts(ResourceMethod method) {
		return true;
	}

	 public void intercept(InterceptorStack stack, ResourceMethod method, Object instance)
     throws InterceptionException {
     try {
         Transaction.begin();
         stack.next(method, instance);
         Transaction.commit();
     } finally {
         Transaction.rollbackIfActive();
     }
 }
	

}
