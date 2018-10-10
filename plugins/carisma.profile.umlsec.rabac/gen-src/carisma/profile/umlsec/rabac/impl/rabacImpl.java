/**
 */
package carisma.profile.umlsec.rabac.impl;

import carisma.profile.umlsec.rabac.RabacPackage;
import carisma.profile.umlsec.rabac.rabac;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>rabac</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link carisma.profile.umlsec.rabac.impl.rabacImpl#getRoles <em>Roles</em>}</li>
 *   <li>{@link carisma.profile.umlsec.rabac.impl.rabacImpl#getRights <em>Rights</em>}</li>
 *   <li>{@link carisma.profile.umlsec.rabac.impl.rabacImpl#getRh <em>Rh</em>}</li>
 *   <li>{@link carisma.profile.umlsec.rabac.impl.rabacImpl#getSsd <em>Ssd</em>}</li>
 *   <li>{@link carisma.profile.umlsec.rabac.impl.rabacImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link carisma.profile.umlsec.rabac.impl.rabacImpl#getDsd <em>Dsd</em>}</li>
 *   <li>{@link carisma.profile.umlsec.rabac.impl.rabacImpl#getAttributeFilters <em>Attribute Filters</em>}</li>
 *   <li>{@link carisma.profile.umlsec.rabac.impl.rabacImpl#getBase_Package <em>Base Package</em>}</li>
 * </ul>
 *
 * @generated
 */
public class rabacImpl extends MinimalEObjectImpl.Container implements rabac {
	/**
	 * The default value of the '{@link #getRoles() <em>Roles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoles()
	 * @generated
	 * @ordered
	 */
	protected static final String ROLES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRoles() <em>Roles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoles()
	 * @generated
	 * @ordered
	 */
	protected String roles = ROLES_EDEFAULT;

	/**
	 * The default value of the '{@link #getRights() <em>Rights</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRights()
	 * @generated
	 * @ordered
	 */
	protected static final String RIGHTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRights() <em>Rights</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRights()
	 * @generated
	 * @ordered
	 */
	protected String rights = RIGHTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getRh() <em>Rh</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRh()
	 * @generated
	 * @ordered
	 */
	protected static final String RH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRh() <em>Rh</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRh()
	 * @generated
	 * @ordered
	 */
	protected String rh = RH_EDEFAULT;

	/**
	 * The default value of the '{@link #getSsd() <em>Ssd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSsd()
	 * @generated
	 * @ordered
	 */
	protected static final String SSD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSsd() <em>Ssd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSsd()
	 * @generated
	 * @ordered
	 */
	protected String ssd = SSD_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * The default value of the '{@link #getDsd() <em>Dsd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDsd()
	 * @generated
	 * @ordered
	 */
	protected static final String DSD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDsd() <em>Dsd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDsd()
	 * @generated
	 * @ordered
	 */
	protected String dsd = DSD_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttributeFilters() <em>Attribute Filters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeFilters()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTRIBUTE_FILTERS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttributeFilters() <em>Attribute Filters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeFilters()
	 * @generated
	 * @ordered
	 */
	protected String attributeFilters = ATTRIBUTE_FILTERS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_Package() <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Package()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Package base_Package;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected rabacImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RabacPackage.Literals.RABAC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRoles() {
		return roles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoles(String newRoles) {
		String oldRoles = roles;
		roles = newRoles;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RabacPackage.RABAC__ROLES, oldRoles, roles));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRights() {
		return rights;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRights(String newRights) {
		String oldRights = rights;
		rights = newRights;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RabacPackage.RABAC__RIGHTS, oldRights, rights));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRh() {
		return rh;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRh(String newRh) {
		String oldRh = rh;
		rh = newRh;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RabacPackage.RABAC__RH, oldRh, rh));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSsd() {
		return ssd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSsd(String newSsd) {
		String oldSsd = ssd;
		ssd = newSsd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RabacPackage.RABAC__SSD, oldSsd, ssd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if (base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if (base_Class != oldBase_Class) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RabacPackage.RABAC__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RabacPackage.RABAC__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDsd() {
		return dsd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDsd(String newDsd) {
		String oldDsd = dsd;
		dsd = newDsd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RabacPackage.RABAC__DSD, oldDsd, dsd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttributeFilters() {
		return attributeFilters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeFilters(String newAttributeFilters) {
		String oldAttributeFilters = attributeFilters;
		attributeFilters = newAttributeFilters;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RabacPackage.RABAC__ATTRIBUTE_FILTERS, oldAttributeFilters, attributeFilters));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Package getBase_Package() {
		if (base_Package != null && base_Package.eIsProxy()) {
			InternalEObject oldBase_Package = (InternalEObject)base_Package;
			base_Package = (org.eclipse.uml2.uml.Package)eResolveProxy(oldBase_Package);
			if (base_Package != oldBase_Package) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RabacPackage.RABAC__BASE_PACKAGE, oldBase_Package, base_Package));
			}
		}
		return base_Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Package basicGetBase_Package() {
		return base_Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Package(org.eclipse.uml2.uml.Package newBase_Package) {
		org.eclipse.uml2.uml.Package oldBase_Package = base_Package;
		base_Package = newBase_Package;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RabacPackage.RABAC__BASE_PACKAGE, oldBase_Package, base_Package));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RabacPackage.RABAC__ROLES:
				return getRoles();
			case RabacPackage.RABAC__RIGHTS:
				return getRights();
			case RabacPackage.RABAC__RH:
				return getRh();
			case RabacPackage.RABAC__SSD:
				return getSsd();
			case RabacPackage.RABAC__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
			case RabacPackage.RABAC__DSD:
				return getDsd();
			case RabacPackage.RABAC__ATTRIBUTE_FILTERS:
				return getAttributeFilters();
			case RabacPackage.RABAC__BASE_PACKAGE:
				if (resolve) return getBase_Package();
				return basicGetBase_Package();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RabacPackage.RABAC__ROLES:
				setRoles((String)newValue);
				return;
			case RabacPackage.RABAC__RIGHTS:
				setRights((String)newValue);
				return;
			case RabacPackage.RABAC__RH:
				setRh((String)newValue);
				return;
			case RabacPackage.RABAC__SSD:
				setSsd((String)newValue);
				return;
			case RabacPackage.RABAC__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
				return;
			case RabacPackage.RABAC__DSD:
				setDsd((String)newValue);
				return;
			case RabacPackage.RABAC__ATTRIBUTE_FILTERS:
				setAttributeFilters((String)newValue);
				return;
			case RabacPackage.RABAC__BASE_PACKAGE:
				setBase_Package((org.eclipse.uml2.uml.Package)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case RabacPackage.RABAC__ROLES:
				setRoles(ROLES_EDEFAULT);
				return;
			case RabacPackage.RABAC__RIGHTS:
				setRights(RIGHTS_EDEFAULT);
				return;
			case RabacPackage.RABAC__RH:
				setRh(RH_EDEFAULT);
				return;
			case RabacPackage.RABAC__SSD:
				setSsd(SSD_EDEFAULT);
				return;
			case RabacPackage.RABAC__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
			case RabacPackage.RABAC__DSD:
				setDsd(DSD_EDEFAULT);
				return;
			case RabacPackage.RABAC__ATTRIBUTE_FILTERS:
				setAttributeFilters(ATTRIBUTE_FILTERS_EDEFAULT);
				return;
			case RabacPackage.RABAC__BASE_PACKAGE:
				setBase_Package((org.eclipse.uml2.uml.Package)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RabacPackage.RABAC__ROLES:
				return ROLES_EDEFAULT == null ? roles != null : !ROLES_EDEFAULT.equals(roles);
			case RabacPackage.RABAC__RIGHTS:
				return RIGHTS_EDEFAULT == null ? rights != null : !RIGHTS_EDEFAULT.equals(rights);
			case RabacPackage.RABAC__RH:
				return RH_EDEFAULT == null ? rh != null : !RH_EDEFAULT.equals(rh);
			case RabacPackage.RABAC__SSD:
				return SSD_EDEFAULT == null ? ssd != null : !SSD_EDEFAULT.equals(ssd);
			case RabacPackage.RABAC__BASE_CLASS:
				return base_Class != null;
			case RabacPackage.RABAC__DSD:
				return DSD_EDEFAULT == null ? dsd != null : !DSD_EDEFAULT.equals(dsd);
			case RabacPackage.RABAC__ATTRIBUTE_FILTERS:
				return ATTRIBUTE_FILTERS_EDEFAULT == null ? attributeFilters != null : !ATTRIBUTE_FILTERS_EDEFAULT.equals(attributeFilters);
			case RabacPackage.RABAC__BASE_PACKAGE:
				return base_Package != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (roles: ");
		result.append(roles);
		result.append(", rights: ");
		result.append(rights);
		result.append(", rh: ");
		result.append(rh);
		result.append(", ssd: ");
		result.append(ssd);
		result.append(", dsd: ");
		result.append(dsd);
		result.append(", attributeFilters: ");
		result.append(attributeFilters);
		result.append(')');
		return result.toString();
	}

} //rabacImpl
