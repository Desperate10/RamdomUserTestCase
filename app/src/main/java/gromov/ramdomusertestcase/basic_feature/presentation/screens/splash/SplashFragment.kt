package gromov.ramdomusertestcase.basic_feature.presentation.screens.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import gromov.ramdomusertestcase.core.extension.autoCleaned
import gromov.ramdomusertestcase.databinding.FragmentSplashBinding


@AndroidEntryPoint
class SplashFragment : Fragment() {

    private var binding: FragmentSplashBinding by autoCleaned()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.ivLogo.startAnimation(rotateAnimation())

        Handler(Looper.getMainLooper()).postDelayed({
            navigateToUsersFragment()
        }, 2000)
    }

    private fun navigateToUsersFragment() {
        findNavController().navigate(
            SplashFragmentDirections.actionSplashFragmentToUsersFragment()
        )
    }

    private fun rotateAnimation() : RotateAnimation {
        val rotate = RotateAnimation(
            0f,
            180f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        rotate.duration = 2000
        rotate.interpolator = LinearInterpolator()
        return rotate
    }
}